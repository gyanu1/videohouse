/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs544.videohouse.service;

import cs544.videohouse.dao.ICategoryDAO;
import cs544.videohouse.domain.Category;
import org.hibernate.SessionFactory;

/**
 *
 * @author Bishal Timilsina
 */
public class CategoryService implements ICategoryService{
    
    private ICategoryDAO categoryDAO;    
    private SessionFactory sf;

    public CategoryService(ICategoryDAO u,SessionFactory sf) {
        categoryDAO = u;
        this.sf = sf;
    }
    
    @Override
    public Category createCategory(String name) {
        Category category = new Category(name);        
        categoryDAO.saveCategory(category);        
        return category;
    }
}
