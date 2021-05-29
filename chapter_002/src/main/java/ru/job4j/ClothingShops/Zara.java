package ru.job4j.ClothingShops;

public class Zara extends ClothingShop {

    @Override
    protected Clothes createClothes(ClothesType type) {
        Clothes clothes = null;
        switch (type) {
            case DRESS:
                clothes = new ZaraDress();
                break;
            case COSTUME:
                clothes = new ZaraCostume();
                break;
            case HAT:
                clothes = new ZaraHat();
                break;
        }
        return clothes;
    }
}
