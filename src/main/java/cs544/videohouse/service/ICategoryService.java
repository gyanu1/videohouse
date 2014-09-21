/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs544.videohouse.service;

import cs544.videohouse.domain.Category;

/**
 *
 * @author Bishal Timilsina
 */
public interface ICategoryService {
    public Category createCategory(String name);    
}
