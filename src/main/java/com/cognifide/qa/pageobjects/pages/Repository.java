package com.cognifide.qa.pageobjects.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.cognifide.qa.bb.qualifier.PageObject;
import com.cognifide.qa.pageobjects.common.Header;
import com.google.inject.Inject;
import com.google.inject.name.Named;

@PageObject
public class Repository {

  @Inject
  @Named("repo.url")
  private String url;

  @Inject
  private WebDriver webDriver;

  @FindBy(css = "h1.public")
  private WebElement title;

  @FindBy(css = "header")
  private Header header;

  public Header getHeader() {
    return header;
  }

  public Repository open() {
    webDriver.get(url);
    return this;
  }
}
