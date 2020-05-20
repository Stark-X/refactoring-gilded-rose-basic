package cn.xpbootcamp.gilded_rose;

class GildedRose {
    Goods[] goods;

    public GildedRose(Goods[] goods) {
        this.goods = goods;
    }

    public void updateQuality() {
        for (Goods good : goods) {
            good.updateByDay();
        }
    }

}
