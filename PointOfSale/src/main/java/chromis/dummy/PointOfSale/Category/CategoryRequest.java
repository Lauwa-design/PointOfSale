package chromis.dummy.PointOfSale.Category;

import lombok.Builder;

@Builder
public record CategoryRequest (
        String categoryName,
        String description

)
{
    public static CategoryModel toCategoryModel(CategoryRequest categoryRequest){
        return CategoryModel.builder()
                .categoryName(categoryRequest.categoryName())
                .description(categoryRequest.description())
                .build();
    }
}
