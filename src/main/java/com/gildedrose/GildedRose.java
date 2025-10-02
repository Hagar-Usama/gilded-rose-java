package com.gildedrose;
import static com.gildedrose.ItemTypes.*;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }
    
    public void updateQuality() {

        for (Item item : items) {

            switch (item.name) {
                case BACKSTAGE_PASSES:
                    updateBackstagePasses(item);
                    break;
                case AGED_BRIE:
                    updateAgedBrie(item);
                    break;
                case SULFURAS:
                    updateSulfuras(item);
                    break;
            
                default:
                    updateNormalItems(item);
            }


        }
    }

    private  void updateNormalItems(Item item) {
        item.quality = Math.max(0, item.quality - 1);
        item.sellIn = item.sellIn - 1;
        if(item.sellIn < 0){
             item.quality = Math.max(0, item.quality - 1);
        }
    }

    private void updateSulfuras(Item item) {
        item.quality = Math.max(80, item.quality);
    }

    private void updateAgedBrie(Item item) {
        item.quality = Math.min(50, item.quality + 1);
        item.sellIn = item.sellIn - 1;
        if(item.sellIn < 0){
            item.quality = Math.min(50, item.quality + 1);
        }
    }

    private void updateBackstagePasses(Item item) {
        int increment = 0;
        if (item.sellIn < 11) increment++;
        if (item.sellIn < 6)  increment++;
        item.quality = Math.min(50, item.quality + increment);
        item.quality = Math.min(50, item.quality + 1);
        item.sellIn = item.sellIn - 1;
        if(item.sellIn < 0){
            item.quality = 0;
        }
    }
}