package com.krieghb.javasnips.experiments.java8test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by krido02 on 5/18/2016.
 *
 *
 */
public class ArticleTest {



    private List<Article> articles;



    public Article getFirstJavaArticle() {

        for (Article article : articles) {
            if (article.getTags().contains("Java")) {
                return article;
            }
        }

        return null;
    }



    public Optional<Article> getFirstJavaArticleB() {
        return articles.stream()
                .filter(article -> article.getTags().contains("Java"))
                .findFirst();
    }

    public List<Article> getAllJavaArticles() {

        List<Article> result = new ArrayList<>();

        for (Article article : articles) {
            if (article.getTags().contains("Java")) {
                result.add(article);
            }
        }

        return result;
    }


    public List<Article> getAllJavaArticlesB() {
        return articles.stream()
                .filter(article -> article.getTags().contains("Java"))
                .collect(Collectors.toList());
    }



    public Map<String, List<Article>> groupByAuthor() {

        Map<String, List<Article>> result = new HashMap<>();

        for (Article article : articles) {
            if (result.containsKey(article.getAuthor())) {
                result.get(article.getAuthor()).add(article);
            } else {
                ArrayList<Article> articles = new ArrayList<>();
                articles.add(article);
                result.put(article.getAuthor(), articles);
            }
        }

        return result;
    }



    public Map<String, List<Article>> groupByAuthorB() {
        return articles.stream()
                .collect(Collectors.groupingBy(Article::getAuthor));
    }


    public Set<String> getDistinctTags() {

        Set<String> result = new HashSet<>();

        for (Article article : articles) {
            result.addAll(article.getTags());
        }

        return result;
    }



    public Set<String> getDistinctTagsB() {
        return articles.stream()
                .flatMap(article -> article.getTags().stream())
                .collect(Collectors.toSet());
    }
}
