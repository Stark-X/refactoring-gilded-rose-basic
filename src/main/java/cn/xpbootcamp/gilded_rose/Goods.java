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
        this.sellIn -= 1;
    }

    boolean isReachQualityTopLimit() {
        return this.quality < 50;
    }

    boolean isReachQualityBottomLimit() {
        return this.quality > 0;
    }

    void updateByDay() {
        switch (this.name) {
            case "Aged Brie":
                increaseQuality();
                break;
            case "Backstage passes to a TAFKAL80ETC concert":
                increaseQuality();

                if (this.sellIn < 11) {
                    increaseQuality();
                }

                if (this.sellIn < 6) {
                    increaseQuality();
                }
                break;
            case "Sulfuras, Hand of Ragnaros":
                return;
            default:
                decreaseQuality();
                break;
        }

        decreaseSellIn();

        if (this.sellIn >= 0) {
            return;
        }
        if (this.name.equals("Aged Brie")) {
            increaseQuality();
        } else {
            if (this.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                this.quality = 0;
            }
            decreaseQuality();
        }
    }

    private void decreaseQuality() {
        if (isReachQualityBottomLimit()) {
            this.quality -= 1;
        }
    }

    private void increaseQuality() {
        if (isReachQualityTopLimit()) {
            this.quality += 1;
        }
    }
}
