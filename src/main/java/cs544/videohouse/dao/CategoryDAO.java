/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs544.videohouse.dao;

import cs544.videohouse.domain.Category;
import javax.transaction.Transactional;
import org.hibernate.SessionFactory;

/**
 *
 * @author Bishal Timilsina
 */
@Transactional
public class CategoryDAO implements ICategoryDAO{
    private SessionFactory sf;

    public CategoryDAO(SessionFactory sf) {
        this.sf = sf;
    }

    @Override
    public void saveCategory(Category cat) {
       System.out.println("CategoryDAO: saving category with id =" + cat.getId());       
       sf.getCurrentSession().persist(cat);
    }
}
