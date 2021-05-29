package ru.job4j.ClothingShops;

public class Gucci extends ClothingShop {
    @Override
    protected Clothes createClothes(ClothesType type) {
        Clothes clothes = null;
        switch (type) {
            case DRESS:
                clothes = new GucciDress();
                break;
            case COSTUME:
                clothes = new GucciCostume();
                break;
            case HAT:
                clothes = new GucciHat();
                break;
        }
        return clothes;
    }
}
