package ru.job4j.shops;

public abstract class ClothingShop {
    public Clothes sellClothes(ClothesType type) {
        Clothes clothes = createClothes(type);
        clothes.tryOn();
        clothes.buy();

        System.out.println("You look beautiful in this " + clothes.getName() + "! Thanks for your purchase.");

        return clothes;

        }

    protected abstract Clothes createClothes(ClothesType type);

}
