package jypark.blog.services;

import java.util.Arrays;
import java.util.List;
import jypark.blog.entities.enumerates.CategoryType;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    public List<CategoryType> getCategories() {
        final List<CategoryType> list = Arrays.asList(CategoryType.values());
        return list;
    }
}
