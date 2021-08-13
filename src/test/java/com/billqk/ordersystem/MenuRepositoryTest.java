package com.billqk.ordersystem;

import com.billqk.ordersystem.constant.Constant;
import com.billqk.ordersystem.database.domain.MenuEntity;
import com.billqk.ordersystem.database.repository.MenuRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class MenuRepositoryTest {
    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private MenuRepository menuRepository;

    @Before
    public void setUp() {
        MenuEntity menuEntity = new MenuEntity();
        menuEntity.setMenuName("Sushi");
        menuEntity.setCategory(Constant.Category.ASIAN);
        menuEntity.setDescription("A staple rice dish of Japanese cuisine");
        menuEntity.setPrice(9.99);
        testEntityManager.persist(menuEntity);
    }

    @Test
    public void whenFindAll_thenReturnProductList() {
        List<MenuEntity> menuEntities = menuRepository.findAll();
        assertThat(menuEntities).hasSize(1);
    }
}
