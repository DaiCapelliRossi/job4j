package ru.job4j.bank;

import java.util.*;

/**
 * Класс содержит список клиентов.
 * В классе реализованы методы для работы банковского приложения.
 *
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
     *
     * @param user пользователь, который добавляется в список.
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод добавляет новый счет пользователю.
     * Осуществляется проверка, что у пользователя еще нет такого счета.
     *
     * @param passport поиск пользователя осуществляется по паспорту.
     * @param account  счет, который мы хотим добавить пользователю.
     */
    public void addAccount(String passport, Account account) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent() && !users.get(user.get()).contains(account)) {
            users.get(user.get()).add(account);
        }
    }

    /**
     * Поиск пользователя по паспорту.
     *
     * @param passport паспорт пользователя.
     * @return user, пользователь с соответствующим паспортом или null, если пользователь не был найден.
     */
    public Optional<User> findByPassport(String passport) {
        return Optional.of(users.keySet()
                        .stream()
                        .filter(s -> s.getPassport().equals(passport))
                        .findFirst())
                        .get();
    }

    /**
     * Поиск счета пользователя по паспорту и реквизитам.
     *
     * @param passport  паспорт пользователя
     * @param requisite реквизиты счета
     * @return account или null, если у пользователя нет запрашиваемого счета
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            return Optional.of(
                    users.get(user.get())
                            .stream()
                            .filter((s -> s.getRequisite().equals(requisite)))
                            .findFirst())
                            .get();
        }
        return Optional.empty();
    }

    /**
     * Метод отвечает за перевод денежных средств с одного счета на другой.
     * Осуществлена проверка существования обоих пользователей и запрашиваемых счетов у обоих пользователей.
     *
     * @param srcPassport   паспорт пользователя, со счета которого будут переведены д/с.
     * @param srcRequisite  реквизиты счета, с которого будут переведены д/с.
     * @param destPassport  паспорт пользователя, на счет которого будут переведены д/с.
     * @param destRequisite реквизиты счета, на которой будут переведены д/с.
     * @param amount        сумма д/с для перевода с одного счета на другой.
     * @return true, если д/с были успешно переведены; false, если операция по переводу не была выполнена.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {

        Optional<Account> srcAccount = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount.isPresent() && destAccount.isPresent() && srcAccount.get().getBalance() >= amount) {
            srcAccount.get().setBalance(srcAccount.get().getBalance() - amount);
            destAccount.get().setBalance(destAccount.get().getBalance() + amount);
            return true;
        }
        return false;
    }
}