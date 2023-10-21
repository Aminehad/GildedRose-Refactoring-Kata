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
        if (!isSulfuras(item)) {
            item.sellIn--;
        }
    }
    
    private void updateAgedBrie() {
        for (int i = 0; i < items.length; i++) {
            increaseQuality(items[i]);
            decreaseSellIn(items[i]);
            if (items[i].sellIn < 0) {
                increaseQuality(items[i]);
            }
        }
    }
    private void updateBackstagePasses() {
        for (int i = 0; i < items.length; i++) {
            increaseQuality(items[i]);
            if (items[i].sellIn < 11) {
                increaseQuality(items[i]);
            }
            if (items[i].sellIn < 6) {
                increaseQuality(items[i]);
            }
            decreaseSellIn(items[i]);
            if (items[i].sellIn < 0) {
                items[i].quality = items[i].quality - items[i].quality;
            }
        }
    }
     private void updateDefault() {
        for (int i = 0; i < items.length; i++) {
            decreaseQuality(items[i]);
            decreaseSellIn(items[i]);
            if (items[i].sellIn < 0) {
                decreaseQuality(items[i]);
            }
        }
    }   
    public void updateQuality() {
        for(Item item : items) {
            switch (item.name) {
                case AGED_BRIE:
                    updateAgedBrie();
                    break;
                case SULFURAS:
                   // updateSulfuras();
                    break;
                case BACKSTAGE_PASSES:
                    updateBackstagePasses();
                    break;
                default:
                    updateDefault();
                    break;
            }
        }
        }
    }
