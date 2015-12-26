/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.dao;

import business.data.Page;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aydil
 */
public class PageDAO {
    private List<Page> pages;
    
    public PageDAO() {
        pages = new ArrayList<Page>();
        pages.add(new Page("Home", "/index.jsp", "user"));
        pages.add(new Page("Home", "/adminIndex.jsp", "admin"));
        pages.add(new Page("Home", "/adminIndex.jsp", "admin"));
        
    }
    
    public void setContextPath(String path) {
        for(Page page:pages) {
            page.setPath(path+page.getPath());
        }
    }
    
    public List<Page> getPage(String user) {
        List<Page> result = new ArrayList<Page>();
        for(Page page:pages) {
            if(page.getUserType().equals(user)) {
                result.add(page);
            }
        }
        return result;
    }
}
