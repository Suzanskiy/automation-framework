package com.racetrac.mobile.multisite.racetrac.flow;

public interface GiftcardFlow {
  boolean isGiftCardPageDisplayed();

  void clickBuyNewGiftCard();

  boolean isBuyNewCardPageOpened();

  void enterPaymentInfo();

  void enterBillingInfo();

  boolean isSuccessPaymentProcessedViewOpened();

  void clickOkOnSuccessPaymentView();

  boolean isPayWithGiftCardPageOpened();

  void requestNewGiftCard();

  int getGiftCardCount();

  void reloadGiftCard();

  String getGiftCardMoneyAmount();
}
