package com.cognifide.qa.pageobjects.pages;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.cognifide.qa.bb.provider.selenium.BobcatWait;
import com.cognifide.qa.bb.qualifier.PageObject;
import com.cognifide.qa.pageobjects.searchresults.SearchResult;
import com.google.inject.Inject;

@PageObject
public class SearchResults {

  private static final String EXPECTED_TITLE = "Search Results";

  @Inject
  private BobcatWait bobcatWait;

  @FindBy(css = ".codesearch-aside a.menu-item")
  private List<WebElement> categories;

  @FindBy(css = "#wiki_search_results .wiki-list-item")
  private List<SearchResult> results;

  public boolean isLoaded() {
    return bobcatWait.withTimeout(10)
        .until(wd -> StringUtils.containsIgnoreCase(wd.getTitle(), EXPECTED_TITLE));
  }

  public void selectCategory(String category) {
    categories.stream()
        .filter(element -> StringUtils.contains(element.getText(), category))
        .findFirst()
        .orElseThrow(() -> new IllegalStateException("Provided category not present on the page"))
        .click();
  }

  public List<String> getResults() {
    return results.stream()
        .map(SearchResult::getTitle)
        .collect(Collectors.toList());
  }
}
