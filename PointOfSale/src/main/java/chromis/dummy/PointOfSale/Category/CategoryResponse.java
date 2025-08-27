package chromis.dummy.PointOfSale.Category;

public record  CategoryResponse (
         String id,
         String categoryName,
         String description
)
{
        public static CategoryResponse fromCategoryModel (CategoryModel categoryModel){
            return new CategoryResponse(
                    categoryModel.getId(),
                    categoryModel.getCategoryName(),
                    categoryModel.getDescription());
        }
}
