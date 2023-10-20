package com.gildedrose;

class GildedRose {
    Item[] items;
   
    static final String AGED_BRIE = "Aged Brie";
    static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";

    public GildedRose(Item[] items) {
        this.items = items;
    }
    private boolean isAgedBrie(Item item) {
        return item.name.equals(AGED_BRIE);
    }
    private boolean isSulfuras(Item item) {
        return item.name.equals(SULFURAS);
    }
    private boolean isBackstagePasses(Item item) {
        return item.name.equals(BACKSTAGE_PASSES);
    }
   
    private void decreaseQuality(Item item) {
        if (item.quality > 0 && !item.name.equals("Sulfuras, Hand of Ragnaros")) {
            item.quality--;
        }
    }
    private void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality++;
        }
    }
    private void decreaseSellIn(Item item) {
        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
            item.sellIn--;
        }
    }
    
    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!isAgedBrie(items[i]) && !isBackstagePasses(items[i])) {
               decreaseQuality(items[i]);
            } else {
                increaseQuality(items[i]); {
                    if (isBackstagePasses(items[i])) {
                        if (items[i].sellIn < 11) {
                            increaseQuality(items[i]);  
                        }

                        if (items[i].sellIn < 6) {
                            increaseQuality(items[i]);
                        }
                    }
                }
            }

            decreaseSellIn(items[i]);

            if (items[i].sellIn < 0) {
                if (!isAgedBrie(items[i])) {
                    if (!isBackstagePasses(items[i])) {
                        decreaseQuality(items[i]);
                    } else {
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                } else {
                   increaseQuality(items[i]);
                }
            }
        }
    }
}