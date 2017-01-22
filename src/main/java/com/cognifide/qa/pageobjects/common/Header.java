package com.cognifide.qa.pageobjects.common;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.cognifide.qa.bb.qualifier.PageObject;
import com.google.inject.Inject;

@PageObject
public class Header {

  @Inject
  private Actions actions;

  @FindBy(css = "input.header-search-input")
  private WebElement searchBox;

  public void searchFor(String query) {
    actions.click(searchBox)
        .sendKeys(query)
        .sendKeys(Keys.ENTER)
        .perform();
  }
}
