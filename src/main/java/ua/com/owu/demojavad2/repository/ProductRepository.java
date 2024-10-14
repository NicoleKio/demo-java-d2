package ua.com.owu.demojavad2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ua.com.owu.demojavad2.entity.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    // витягуємо ліст продуктів, де ціни цсіх між макс та мін ціною
    List<Product> findAllByPriceBetween(Double minPrice, Double maxPrice);

    // витягуємо ліст/копію продуктів/ліст з бінами, де ціна продукту більше мін, але меньше макс - запит jpql
    // оперирует запросами, составленными по отношению к сущностям JPA, в отличие от прямых запросов к таблицам бд.
    @Query("select p from Product p where p.price > :minPrice and p.price < :maxPrice")
    List<Product> findAllByPriceBetweenWithJpql(Double minPrice, Double maxPrice);

    @Query(value = "select * from products p where p.price > :minPrice and p.price < :maxPrice")
    List<Product> findAllByPriceBetweenWithSql(Double minPrice, Double maxPrice);

    List<Product> findAllByPriceGreaterThan(Double minPrice);

    List<Product> findAllByPriceLessThan(Double maxPrice);

}

//-----------------------------------------------------------------------
//Аннотация Spring @Repository используется для указания того, что класс предоставляет механизм для операций хранения, извлечения, поиска, обновления и удаления объектов .
// репозиторій - це інтерфейс, який бере продукт і перетрорює його копію на бін, яку потім будемо юзати
// Репозитории Spring Data JPA – это интерфейсы, которые можно определять для получения доступа к данным.
// JPA-запросы создаются автоматически на основе имен методов.
// Например, интерфейс CityRepository может объявить метод findAllByState(String state) для поиска всех городов в данном штате.