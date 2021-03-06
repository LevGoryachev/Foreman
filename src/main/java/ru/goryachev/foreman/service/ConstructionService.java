package ru.goryachev.foreman.service;

import com.ibm.icu.text.Transliterator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.goryachev.foreman.dao.ConstructionsDAO;
import ru.goryachev.foreman.dto.ConstructionDTO;
import ru.goryachev.foreman.entities.Construction;
import ru.goryachev.foreman.entities.Entity;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConstructionService {

    @Autowired
    private ConstructionsDAO constructionsDAO;

    public List<Construction> getAll() {
        return constructionsDAO.getAll();
    }

    public void create(Entity entity) {
        constructionsDAO.create(entity);
    }

    public void update(Entity entity) {
        constructionsDAO.update(entity);
    }

    public void delete(int id) {
        constructionsDAO.delete(id);
    }

    public Construction getByName(String name) {
        return constructionsDAO.getByName(name);
    }

    public Construction getById(int id) {
        return constructionsDAO.getById(id);
    }

    public Construction getDTOByUrlName(String urlName) {

        return null;
    }

    public ConstructionDTO getDTOById(int id) {

        final String CYRILLIC_TO_LATIN = "Cyrillic-Latin";
        Transliterator toLatin = Transliterator.getInstance(CYRILLIC_TO_LATIN);

        ConstructionDTO constructionDTO = new ConstructionDTO();

        Construction construction = constructionsDAO.getById(id);
        String name = construction.getName();

        constructionDTO.setId(construction.getId());
        constructionDTO.setCodenumber(construction.getCodenumber());
        constructionDTO.setName(name);
        constructionDTO.setDescription(construction.getDescription());
        constructionDTO.setUrlName(toLatin.transliterate(name)); //transliteration for url

        return constructionDTO;
    }

    public List<ConstructionDTO> getAllDTO() {

        List <ConstructionDTO> list = new ArrayList<>();

        for (Construction construction: constructionsDAO.getAll()) {

            Transliterator toLatin = Transliterator.getInstance("Any-Latin; NFD; [^\\p{Alnum}] Remove");
            String name = construction.getName();

            ConstructionDTO constructionDTO = new ConstructionDTO();
            constructionDTO.setId(construction.getId());
            constructionDTO.setCodenumber(construction.getCodenumber());
            constructionDTO.setName(name);
            constructionDTO.setDescription(construction.getDescription());
            constructionDTO.setUrlName(toLatin.transform(name));
            list.add(constructionDTO);
        }
        return list;
    }
}
