package gmail.roadtojob2019.brewery.repository;

import gmail.roadtojob2019.brewery.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe,Long> {
}
