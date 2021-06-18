package ru.job4j.shops;

public class Gucci extends ClothingShop {
    @SuppressWarnings("checkstyle:MissingSwitchDefault")
    @Override
    protected Clothes createClothes(ClothesType type) {
        Clothes clothes = null;
        if (type == ClothesType.DRESS) {
            clothes = new GucciDress();
        } else if (type == ClothesType.COSTUME) {
            clothes = new GucciCostume();
        } else if (type == ClothesType.HAT) {
            clothes = new GucciHat();
        }
        return clothes;
    }
}
