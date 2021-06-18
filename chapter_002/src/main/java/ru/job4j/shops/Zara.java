package ru.job4j.shops;

public class Zara extends ClothingShop {

    @Override
    protected Clothes createClothes(ClothesType type) {
        Clothes clothes = null;
        if (type == ClothesType.DRESS) {
            clothes = new ZaraDress();
        } else if (type == ClothesType.COSTUME) {
            clothes = new ZaraCostume();
        } else if (type == ClothesType.HAT) {
            clothes = new ZaraHat();
        }
        return clothes;
    }
}
