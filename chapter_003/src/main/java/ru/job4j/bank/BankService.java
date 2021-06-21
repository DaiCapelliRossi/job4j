package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс содержит список клиентов.
 * В классе реализованы методы для работы банковского приложения.
 * @author ANASTASIA OSTROUMOVA
 * @version 1.0
 */
public class BankService {
    /**
     * Пользователи и привязанные к ним счета хранятся в коллекции типа HashMap.
     */
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет нового пользователя в список.
     * @param user пользователь, который добавляется в список.
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод добавляет новый счет пользователю.
     * Осуществляется проверка, что у пользователя еще нет такого счета.
     * @param passport поиск пользователя осуществляется по паспорту.
     * @param account счет, который мы хотим добавить пользователю.
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (!users.get(user).contains(account)) {
            users.get(user).add(account);
        }
    }

    /**
     * Поиск пользователя по паспорту.
     * @param passport паспорт пользователя.
     * @return user, пользователь с соответствующим паспортом или null, если пользователь не был найден.
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Поиск счета пользователя по паспорту и реквизитам.
     * @param passport паспорт пользователя
     * @param requisite реквизиты счета
     * @return account или null, если у пользователя нет запрашиваемого счета
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            for (Account account : accounts) {
                if (account.getRequisite().equals(requisite)) {
                    return account;
                }
            }
        }

        return null;
    }

    /**
     * Метод отвечает за перевод денежных средств с одного счета на другой.
     * Осуществлена проверка существования обоих пользователей и запрашиваемых счетов у обоих пользователей.
     * @param srcPassport паспорт пользователя, со счета которого будут переведены д/с.
     * @param srcRequisite реквизиты счета, с которого будут переведены д/с.
     * @param destPassport паспорт пользователя, на счет которого будут переведены д/с.
     * @param destRequisite реквизиты счета, на которой будут переведены д/с.
     * @param amount сумма д/с для перевода с одного счета на другой.
     * @return true, если д/с были успешно переведены; false, если операция по переводу не была выполнена.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {

        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null && srcAccount.getBalance() >= amount) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            return true;
        }
        return false;
    }
}