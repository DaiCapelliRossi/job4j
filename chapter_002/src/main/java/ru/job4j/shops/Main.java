package ru.job4j.shops;

public class Main {
    public static void main(String[] args) {
        ClothingShop zara = new Zara();
        zara.sellClothes(ClothesType.DRESS);

        ClothingShop gucci = new Gucci();
        gucci.sellClothes(ClothesType.COSTUME);
        gucci.sellClothes(ClothesType.HAT);
    }
}
