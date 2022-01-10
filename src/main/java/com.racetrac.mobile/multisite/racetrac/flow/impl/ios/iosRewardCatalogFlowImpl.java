package com.racetrac.mobile.multisite.racetrac.flow.impl.ios;

import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.flow.RewardsCatalogFlow;
import com.racetrac.mobile.util.appium.SwipeScroll;
import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static com.racetrac.mobile.framework.constants.PlatformsConstants.IOS;
import static com.racetrac.mobile.util.appium.AppiumDriverUtils.swipeDown;
import static com.racetrac.mobile.util.appium.SwipeScroll.swipeToElement;

@Profile(IOS)
@Component
public class iosRewardCatalogFlowImpl extends BaseFlow implements RewardsCatalogFlow {

  private static final int MINIMUM_SPENT_AMOUNT = 60;

  @Step
  @Override
  public void clickRedeemBtn() {
    try {
      swipeToElement(SwipeScroll.Direction.UP, getRewardsCatalogPage().getRedeemBtn());// swipeDownHard(); //The "UAT gal Reward" shifted down
      getRewardsCatalogPage().getRedeemBtn().click();
    } catch (NoSuchElementException e) {
      LOG.warn("Unable to click btn on reward catalog redeem");
    }
  }

  @Step
  @Override
  public void clickRedeemOnPopupBtn() {
    getEnoughRedeemPointsPopUp().waitUntilIsOpened();
    try {
      getEnoughRedeemPointsPopUp().getRedeemPopupBtn().click();
    } catch (NoSuchElementException | TimeoutException e) {
      LOG.warn("Points screen not opened, skipping..");
    }
  }

  @Step
  @Override
  public boolean isUnclaimedRewardsIsDisplayed() {
    try {
      swipeDown();
      return getRewardsCatalogPage().getUnclaimedRewardsLabel().isDisplayed();
    } catch (NoSuchElementException e) {
      LOG.warn("Unclaimed Rewards Label is not displayed");
      return false;
    }
  }

  @Step
  @Override
  public boolean isQuantityOfPointsEnough() {
    try {
      int totalPointsOnAccount =
          Integer.parseInt(getRewardsCatalogPage().getRewardsCatalogNumberOfPoints().getText());
      if (totalPointsOnAccount >= MINIMUM_SPENT_AMOUNT) {
        return true;
      }
    } catch (NoSuchElementException e) {
      LOG.warn("The number of points is not enough to make redeem");
    }
    return false;
  }

  @Step
  @Override
  public boolean isRewardsCatalogPageOpened() {
    return getRewardsCatalogPage().waitUntilIsOpened();
  }

  @Step
  @Override
  public int getAvailablePoints() {
    return Integer.parseInt(
        getRewardsCatalogPage().getRewardsCatalogNumberOfPoints().getAttribute("value"));
  }

  @Override
  public int getRewardPrice() {
    return Integer.parseInt(
        getRewardsCatalogPage().getRewardPoints().getAttribute("value").split(" ")[0]);
  }

  @Step
  @Override
  public void closeRewardsCatalog() {
    getRewardsCatalogPage().getCloseBtn().click();
  }

  @Override
  public int getUnclaimedRewardsCounter() {
    final WebElement unclaimedRewardsCounter = getRewardsCatalogPage().getUnclaimedRewardsCounter();
    swipeToElement(SwipeScroll.Direction.DOWN, unclaimedRewardsCounter);
    return Integer.parseInt(
        unclaimedRewardsCounter.getAttribute("value"));
  }

  @Override
  public boolean isElementsOfRewardsCatalogDisplayed() {
    try {
      return getRewardsCatalogPage().waitUntilIsOpened();

    } catch (NoSuchElementException e) {
      LOG.warn("elements of Rewards catalog are not displayed");
      return false;
    }
  }

  @Override
  public boolean isSadSmilePopUpShown() {
    return getSadSmileRewardCatalogView().waitUntilIsOpened();
  }

  @Override
  public void waitUntilSadSmilePopUpShown() {}

  @Step
  @Override
  public void navigateBack() {
    getRewardsCatalogPage().getCloseBtn().click();
  }
}
