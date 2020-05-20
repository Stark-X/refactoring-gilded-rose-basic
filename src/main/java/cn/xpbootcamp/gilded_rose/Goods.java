package cn.xpbootcamp.gilded_rose;

public class Goods {
    private String name;
    private int sellIn;
    private int quality;

    public void setName(String name) {
        this.name = name;
    }

    public void setSellIn(int sellIn) {
        this.sellIn = sellIn;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public String getName() {
        return name;
    }

    public int getSellIn() {
        return sellIn;
    }

    public int getQuality() {
        return quality;
    }

    public Goods(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    void decreaseSellIn() {
        setSellIn(getSellIn() - 1);
    }

    boolean isReachQualityTopLimit() {
        return getQuality() < 50;
    }

    boolean isReachQualityBottomLimit() {
        return getQuality() > 0;
    }

    void updateByDay() {
        if (!getName().equals("Aged Brie")
                && !getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
            if (isReachQualityBottomLimit()) {
                if (!getName().equals("Sulfuras, Hand of Ragnaros")) {
                    setQuality(getQuality() - 1);
                }
            }
        } else {
            if (isReachQualityTopLimit()) {
                setQuality(getQuality() + 1);

                if (getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (getSellIn() < 11) {
                        if (isReachQualityTopLimit()) {
                            setQuality(getQuality() + 1);
                        }
                    }

                    if (getSellIn() < 6) {
                        if (isReachQualityTopLimit()) {
                            setQuality(getQuality() + 1);
                        }
                    }
                }
            }
        }

        if (!getName().equals("Sulfuras, Hand of Ragnaros")) {
            decreaseSellIn();
        }

        if (getSellIn() < 0) {
            if (!getName().equals("Aged Brie")) {
                if (!getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (isReachQualityBottomLimit()) {
                        if (!getName().equals("Sulfuras, Hand of Ragnaros")) {
                            setQuality(getQuality() - 1);
                        }
                    }
                } else {
                    setQuality(0);
                }
            } else {
                if (isReachQualityTopLimit()) {
                    setQuality(getQuality() + 1);
                }
            }
        }
    }
}
