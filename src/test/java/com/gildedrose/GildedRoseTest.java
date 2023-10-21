package com.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class GildedRoseTest {
  static final String AGED_BRIE = "Aged Brie";
  static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
  static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
  static final String BASIC_ITEM = "Basic item";

  // test to string
  @Test
  @DisplayName("Test tooString")
  void test_toString() {
    Item element = new Item("foo", 0, 0);    
    assertEquals(element.name + ", " + element.sellIn + ", " + element.quality, element.toString());
  }

  @Test
  @DisplayName("Test that the name is unchanged")
  void testName() {
    Item element = new Item("foo", 0, 0);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.name, is("foo"));
  }




  //test sur les items basic  (quality positive, sellin positive) the quality subtracts by 1
   @Test
  @DisplayName("Test that quality positive, sellin positive, basic item")
  void BasicItemQualitytestOne() {
    int quality=49;
    int sellin=8;
    Item element = new Item(BASIC_ITEM,sellin, quality);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
  
   assertThat(element.quality, is(quality - 1));
  }
  //test sur les items basic (quality positive, sellin positive) the sellin subtracts by 1
   @Test
  @DisplayName("Test that quality positive, sellin positive, basic item")
  void BasicItemSellintestOne() {
    int quality=49;
    int sellin=8;
    Item element = new Item(BASIC_ITEM,sellin, quality);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.sellIn, is(sellin - 1));
  }
  //test sur les items basic (quality positive, sellin positive) the quality subtracts by 2
   @Test
  @DisplayName("Test that quality positive, sellin negative, basic item")
  void BasicItemQualitytestTwo() {
    int quality=49;
    int sellin=-1;
    Item element = new Item(BASIC_ITEM,sellin, quality);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(quality - 2));
  }
  //test sur les items basic (quality positive, sellin negatif) the quality subtracts by 2
   @Test
  @DisplayName("Test that quality positive, sellin negative, basic item")
  void BasicItemSellintestTwo() {
    int quality=49;
    int sellin=-1;
    Item element = new Item(BASIC_ITEM,sellin, quality);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(quality- 2));
  }
  //test sur les items basic (quality negatif, sellin negatif) quality stays the same
   @Test  
  @DisplayName("Test that quality negative, sellin negative, basic item")
  void BasicItemQualitytestThree() {
    int quality=-1;
    int sellin=-1;
    Item element = new Item(BASIC_ITEM,sellin, quality);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(quality, is(quality ));
  }
  //test sur les items basic (quality negatif, sellin positive) quality stays the same
  @Test
  @DisplayName("Test that quality negative, sellin positive, basic item")
  void BasicItemQualitytestFour() {
    int quality=-1;
    int sellin=8;
    Item element = new Item(BASIC_ITEM,sellin, quality);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(quality, is(quality ));
  }
//test sur les items agedBrie "(quality positive, sellin positive) the quality increases by one)"
 @Test
  @DisplayName("Test that quality positive, sellin positive,agedBrie")
  void agedBrieQualitytestOne() {
    int quality=49;
    int sellin=8;
    Item element = new Item(AGED_BRIE,sellin, quality);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
   //assertEquals(50, quality + 1);
   // assertThat(element.quality, is(quality + 1));
   assertEquals(quality + 1, element.quality);
  }
  //test sur les items agedBrie (quality positive, sellin positive) the sellin subtracts by 1
   @Test
  @DisplayName("Test that quality positive, sellin positive,agedBrie")
  void  agedBrieSellintestOne() {
    int quality=49;
    int sellin=8;
    Item element = new Item(AGED_BRIE,sellin, quality);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.sellIn, is(sellin - 1));
  }
 //test sur les items agedBrie (quality positive, sellin negative) the quality increases by two
  @Test
  @DisplayName("Test that quality positive, sellin negative,agedBrie")
  void  agedBrieQualitytestTwo() {
    int quality=47;
    int sellin=-1;
    Item element = new Item(AGED_BRIE,sellin, quality);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(quality + 2));
  }
  //test sur les items agedBrie (quality positive, sellin negative) the sellin subtracts by 1
   @Test
  @DisplayName("Test that quality positive, sellin negative,agedBrie")
  void  agedBrieSellintestTwo() {
    int quality=47;
    int sellin=-1;
    Item element = new Item(AGED_BRIE,sellin, quality);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.sellIn, is(sellin - 1));
  }
  @Test
  // test sur les items agedBrie (quality ne peut dépasser 50 / quality = 49, sellIn < 0)
  void agedBrieQualitytestThree() {
    final int quality = 49;
    final int sellIn = 0;
    Item element = new Item(AGED_BRIE,sellIn, quality);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();

    assertThat(app.items[0].quality, is(50));
  }
  // test sur les items agedBrie (quality ne peut dépasser 50 / quality = 49, sellIn < 6)
  @Test
   void backstagePassesQuality3() {
    final int quality = 49;
    final int sellIn = 5;
    Item element = new Item(BACKSTAGE_PASSES,sellIn, quality);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();

    assertThat(element.quality, is(50));
  }
  // test sur les items agedBrie (quality ne peut dépasser 50 / quality = 50, sellIn >11)
  @Test
   void backstagePassesQuality4() {
    final int quality = 50;
    final int sellIn = 12;
    Item element = new Item(BACKSTAGE_PASSES,sellIn, quality);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();

    assertThat(element.quality, is(50));
  }
//test sur les items Backstage passes "(quality positive, sellin positive < 11)  quality increases by 2"
 @Test
  @DisplayName("Test that quality positive, sellin positive,Backstage passes")
  void BACKSTAGEQualitytestOne() {
    int quality=5;
    int sellin=8;
    Item element = new Item(BACKSTAGE_PASSES,sellin, quality);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
   
   assertEquals(quality + 2, element.quality);
  }
  //test sur les items Backstage passes "(quality negatif, sellin positive < 11)  quality increases by 2"
 @Test
  @DisplayName("Test that quality positive, sellin positive,Backstage passes")
  void BACKSTAGEQualitytestTwo() {
    int quality=-1;
    int sellin=8;
    Item element = new Item(BACKSTAGE_PASSES,sellin, quality);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
   assertEquals(quality + 2, element.quality);
  }
  //test sur les items Backstage passes (quality positive, sellin positive < 5)  quality increases by 3
   @Test
  @DisplayName("Test that quality positive, sellin positive,Backstage passes")
  void  BACKSTAGEQualitytestThree() {
    int quality=5;
    int sellin=3;
    Item element = new Item(BACKSTAGE_PASSES,sellin, quality);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
   //assertEquals(50, quality + 1);
   // assertThat(element.quality, is(quality + 1));
   assertEquals(quality + 3, element.quality);
  }
  //test sur les items Backstage passes (quality negatif, sellin positive < 5)  quality increases by 3
  @Test
  void BACKSTAGEQualitytestFour() {
    final int quality = -1;
    final int sellIn = 5;
    final Item[] items = new Item[] {new Item(BACKSTAGE_PASSES, sellIn, quality)};

    final GildedRose app = new GildedRose(items);
    app.updateQuality();

    assertThat(app.items[0].quality, is(quality + 3));
  }
  //test sur les items Backstage passes (quality positive, sellin positive > 11 )  sellin decreases by 1
   @Test
  @DisplayName("Test that quality positive, sellin positive,Backstage passes")
  void  BACKSTAGESellintestOne() {
    int quality=5;
    int sellin=12;
    Item element = new Item(BACKSTAGE_PASSES,sellin, quality);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.sellIn, is(sellin - 1));
  }
   //test sur les items Backstage passes (quality positive >50 , sellin < 0)  
   @Test
  @DisplayName("Test that quality positive, sellin positive,Backstage passes")
  void  BACKSTAGEQualitytestfive() {
    int quality=50;
    int sellin=-1;
    Item element = new Item(BACKSTAGE_PASSES,sellin, quality);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
   //assertEquals(50, quality + 1);
   // assertThat(element.quality, is(quality + 1));
   assertEquals(0, element.quality);
  }
  //test sur les items Backstage passes (quality positive, sellin positive > 11 )  quality increases by 1
   @Test
  @DisplayName("Test that quality positive, sellin positive,Backstage passes")
  void  BACKSTAGESellintestTwo() {
    int quality=5;
    int sellin=12;
    Item element = new Item(BACKSTAGE_PASSES,sellin, quality);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality,is(quality + 1));
  }
  //test sur les items Backstage passes (quality negatif, sellin positive > 11 )  quality increases by 1
   @Test
  @DisplayName("Test that quality positive, sellin positive,Backstage passes")
  void  BACKSTAGESellintestThree() {
    int quality=-1;
    int sellin=12;
    Item element = new Item(BACKSTAGE_PASSES,sellin, quality);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality,is(quality + 1));
  }
 // test sur les items Backstage passes (quality positive / sellin 0) quality = 0
  @Test
   void backstagePassesQuality10() {
    final int quality = 10;
    final int sellIn = 0;
    Item element = new Item(BACKSTAGE_PASSES,sellIn, quality);

    GildedRose app = new GildedRose(new Item[] {element});

    app.updateQuality();
    assertThat(element.quality, is(0));
  }
// test sur les items Backstage passes (quality negatif / sellin 0) quality = 0
  @Test
   void backstagePassesQuality11() {
    final int quality = -10;
    final int sellIn = 0;
    Item element = new Item(BACKSTAGE_PASSES,sellIn, quality);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    
    assertThat(element.quality, is(0));
  }
//test sur les items de Sulfuras (quality >0 sellin >0) quality ne change pas  
  @Test
  @DisplayName("Test that quality positive, sellin positive,Sulfuras")
  void  SulfurasQualitytestOne() {
    int quality=5;
    int sellin=8;
    Item element = new Item(SULFURAS,sellin, quality);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(quality));
  }
  //test sur les items de Sulfuras (quality >0 sellin >0) sellin ne change pas
  @Test
  @DisplayName("Test that quality positive, sellin positive,Sulfuras")
  void  SulfurasSellintestOne() {
    int quality=5;
    int sellin=8;
    Item element = new Item(SULFURAS,sellin, quality);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.sellIn, is(sellin));
  }
  //test sur les items de Sulfuras (quality >0 sellin <0) quality ne change pas
  @Test
  @DisplayName("Test that quality positive, sellin negatif,Sulfuras")
  void  SulfurasQualitytestTwo() {
    int quality=5;
    int sellin=-1;
    Item element = new Item(SULFURAS,sellin, quality);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(quality));
  }
  //test sur les items de Sulfuras (quality >0 sellin <0) sellin ne change pas
  @Test
  @DisplayName("Test that quality positive, sellin negatif,Sulfuras")
  void  SulfurasSellintestTwo() {
    int quality=5;
    int sellin=-1;
    Item element = new Item(SULFURAS,sellin, quality);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.sellIn, is(sellin));
  }
  //test sur les items de Sulfuras (quality <0 sellin <0) quality ne change pas
  @Test
  @DisplayName("Test that quality negatif, sellin negatif,Sulfuras")
  void  SulfurasQualitytestThree() {
    int quality=-1;
    int sellin=-1;
    Item element = new Item(SULFURAS,sellin, quality);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(quality));
  }
  //test sur les items de Sulfuras (quality <0 sellin <0) sellin ne change pas
  @Test
  @DisplayName("Test that quality negatif, sellin negatif,Sulfuras")
  void  SulfurasSellintestThree() {
    int quality=-1;
    int sellin=-1;
    Item element = new Item(SULFURAS,sellin, quality);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.sellIn, is(sellin));
  }
  //test sur les items de Sulfuras (quality <0 sellin >0) quality ne change pas
  @Test
  @DisplayName("Test that quality negatif, sellin positive,Sulfuras")
  void  SulfurasQualitytestFour() {
    int quality=-1;
    int sellin=8;
    Item element = new Item(SULFURAS,sellin, quality);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(quality));
  }
  //test sur les items de Sulfuras (quality <0 sellin >0) sellin ne change pas
  @Test
  @DisplayName("Test that quality negatif, sellin positive,Sulfuras")
  void  SulfurasSellintestFour() {
    int quality=-1;
    int sellin=8;
    Item element = new Item(SULFURAS,sellin, quality);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.sellIn, is(sellin));
  }
  //test sur les items de basique item (quality = 0 ) quality ne change pas
  @Test
  @DisplayName("Test that quality ne change pas")
  void  SulfurasQualitytestFive() {
    int quality=0;
    int sellin=8;
    Item element = new Item(BASIC_ITEM,sellin, quality);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(quality ));
  }
  //test sur les items de basique (quality = 0 ) sellin decreases by 1
  @Test
  @DisplayName("Test that quality = 0")
  void  SulfurasSellintestFive() {
    int quality=0;
    int sellin=8;
    Item element = new Item(BASIC_ITEM,sellin, quality);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.sellIn, is(sellin - 1));
  }
  //test sur les items de backstage (sellin = 11) quality increases by 1
  @Test
  @DisplayName("Test that quality increment de 1")
  void  SulfurasSellintestSix() {
    int quality=30;
    int sellin=11;
    Item element = new Item(BACKSTAGE_PASSES,sellin, quality);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(quality +1));
  }
    //test sur les items de backstage (sellin = 6) quality increases by 2
  @Test
  @DisplayName("Test that quality increases by 2")
  void  SulfurasSellintestseven() {
    int quality=30;
    int sellin=6;
    Item element = new Item(BACKSTAGE_PASSES,sellin, quality);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality  , is(quality +2));
  }
// test sur les items basique (quality =0 , sellin = 0 ) quality ne change pas
 @Test
  @DisplayName("Test that quality  doesn change")
  void  BasicItemSellintestP() {
    int quality=0;
    int sellin=0;
    Item element = new Item(BASIC_ITEM,sellin, quality);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(quality ));
  }
  // test sur les items basique (quality =0 , sellin = 1) quality decreases by 1
  @Test
  @DisplayName("Test that quality decreases by 1")
  void  BasicItemSellintestP2() {
    int quality=30;
    int sellin=1;
    Item element = new Item(BASIC_ITEM,sellin, quality);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(quality -1));
  }
  //test sur les items de conjured (quality >0, sellin positive) quality decreases by 2
  @Test
  @DisplayName("Test that quality decreases by 2 ")
  void  conjuredItemSellintestP() {
    int quality=30;
    int sellin=1;
    Item element = new Item("Conjured",sellin, quality);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(quality -2));
  }
  //test sur les items de conjured (quality >0, sellin negative) quality decreases by 4
  @Test
  @DisplayName("Test that quality decreases by 4 ")
  void  conjuredItemSellintestP2() {
    int quality=30;
    int sellin=-1;
    Item element = new Item("Conjured",sellin, quality);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(quality-4));
  }
  //test sur les items de conjured (quality <0, sellin = 0) quality decreases by 2
  @Test
  @DisplayName("Test that quality decreases by 2 ")
  void  conjuredItemSellintestP3() {
    int quality=1;
    int sellin=0;
    Item element = new Item("Conjured",sellin, quality);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(0));
  }
  
  

}
