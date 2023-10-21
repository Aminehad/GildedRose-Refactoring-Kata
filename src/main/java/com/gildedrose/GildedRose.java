package com.gildedrose;

class GildedRose {
    Item[] items;
   
    static final String AGED_BRIE = "Aged Brie";
    static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    static final String CONJURED = "Conjured";
    public GildedRose(Item[] items) {
        this.items = items;
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
        if (!item.name.equals(SULFURAS)) {
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
    private void updateConjured() {
        for (int i = 0; i < items.length; i++) {
            decreaseQuality(items[i]);
            decreaseQuality(items[i]);
            decreaseSellIn(items[i]);
            if (items[i].sellIn < 0) {
                decreaseQuality(items[i]);
                decreaseQuality(items[i]);
               
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
                case CONJURED:
                    updateConjured();
                    break;
                default:
                    updateDefault();
                    break;
            }
        }
        }
    }
