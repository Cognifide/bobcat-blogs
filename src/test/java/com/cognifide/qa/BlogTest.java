package com.cognifide.qa;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.cognifide.qa.bb.junit.Modules;
import com.cognifide.qa.bb.junit.TestRunner;
import com.cognifide.qa.pageobjects.pages.Repository;
import com.cognifide.qa.pageobjects.pages.SearchResults;
import com.google.inject.Inject;

@RunWith(TestRunner.class)
@Modules(GuiceModule.class)
public class BlogTest {

  private static final String SEARCHED_PAGE = "Getting Started";

  @Inject
  private Repository repository;

  @Inject
  private SearchResults searchResults;

  @Test
  public void shouldFindGettingStarted() {
    repository.open()
        .getHeader()
        .searchFor(SEARCHED_PAGE);
    assertThat(searchResults.isLoaded(), is(true));

    searchResults.selectCategory("Wikis");
    assertThat(searchResults.getResults(), hasItem("Getting Started"));
  }
}
