package cn.xpbootcamp.gilded_rose;

class GildedRose {
    Goods[] goods;

    public GildedRose(Goods[] goods) {
        this.goods = goods;
    }

    public void updateQuality() {
        for (Goods good : goods) {
            if (!good.getName().equals("Aged Brie")
                    && !good.getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (good.getQuality() > 0) {
                    if (!good.getName().equals("Sulfuras, Hand of Ragnaros")) {
                        good.setQuality(good.getQuality() - 1);
                    }
                }
            } else {
                if (good.getQuality() < 50) {
                    good.setQuality(good.getQuality() + 1);

                    if (good.getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (good.getSellIn() < 11) {
                            if (good.getQuality() < 50) {
                                good.setQuality(good.getQuality() + 1);
                            }
                        }

                        if (good.getSellIn() < 6) {
                            if (good.getQuality() < 50) {
                                good.setQuality(good.getQuality() + 1);
                            }
                        }
                    }
                }
            }

            if (!good.getName().equals("Sulfuras, Hand of Ragnaros")) {
                good.setSellIn(good.getSellIn() - 1);
            }

            if (good.getSellIn() < 0) {
                if (!good.getName().equals("Aged Brie")) {
                    if (!good.getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (good.getQuality() > 0) {
                            if (!good.getName().equals("Sulfuras, Hand of Ragnaros")) {
                                good.setQuality(good.getQuality() - 1);
                            }
                        }
                    } else {
                        good.setQuality(0);
                    }
                } else {
                    if (good.getQuality() < 50) {
                        good.setQuality(good.getQuality() + 1);
                    }
                }
            }
        }
    }
}
