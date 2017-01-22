package com.cognifide.qa.pageobjects.searchresults;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.cognifide.qa.bb.qualifier.PageObject;

@PageObject
public class SearchResult {

  @FindBy(css = ".title a")
  private WebElement title;

  public String getTitle() {
    return title.getText();
  }
}
