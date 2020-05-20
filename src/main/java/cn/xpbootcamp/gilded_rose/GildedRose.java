package cn.xpbootcamp.gilded_rose;

class GildedRose {
    Goods[] goods;

    public GildedRose(Goods[] goods) {
        this.goods = goods;
    }

    public void update_quality() {
        for (int i = 0; i < goods.length; i++) {
            if (!goods[i].getName().equals("Aged Brie")
                    && !goods[i].getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (goods[i].getQuality() > 0) {
                    if (!goods[i].getName().equals("Sulfuras, Hand of Ragnaros")) {
                        goods[i].setQuality(goods[i].getQuality() - 1);
                    }
                }
            } else {
                if (goods[i].getQuality() < 50) {
                    goods[i].setQuality(goods[i].getQuality() + 1);

                    if (goods[i].getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (goods[i].getSellIn() < 11) {
                            if (goods[i].getQuality() < 50) {
                                goods[i].setQuality(goods[i].getQuality() + 1);
                            }
                        }

                        if (goods[i].getSellIn() < 6) {
                            if (goods[i].getQuality() < 50) {
                                goods[i].setQuality(goods[i].getQuality() + 1);
                            }
                        }
                    }
                }
            }

            if (!goods[i].getName().equals("Sulfuras, Hand of Ragnaros")) {
                goods[i].setSellIn(goods[i].getSellIn() - 1);
            }

            if (goods[i].getSellIn() < 0) {
                if (!goods[i].getName().equals("Aged Brie")) {
                    if (!goods[i].getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (goods[i].getQuality() > 0) {
                            if (!goods[i].getName().equals("Sulfuras, Hand of Ragnaros")) {
                                goods[i].setQuality(goods[i].getQuality() - 1);
                            }
                        }
                    } else {
                        goods[i].setQuality(0);
                    }
                } else {
                    if (goods[i].getQuality() < 50) {
                        goods[i].setQuality(goods[i].getQuality() + 1);
                    }
                }
            }
        }
    }
}
