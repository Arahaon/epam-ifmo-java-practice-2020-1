package com.ifmo.epampractice.service;

import com.ifmo.epampractice.dao.SubjectsDAO;
import com.ifmo.epampractice.entity.Subjects;

import java.util.List;
import java.util.Optional;

public final class  SubjectsService {
    private static final SubjectsService SUBJECTS_SERVICE = new SubjectsService();
    private static final SubjectsDAO SUBJECTS_DAO = new SubjectsDAO();

    private SubjectsService() {}

    public static SubjectsService getInstance() {
        return SUBJECTS_SERVICE;
    }
    public Subjects addObject(final Subjects subject) {
        return SUBJECTS_DAO.addObject(subject);
    }

    public List<Subjects> getAll() {
        return SUBJECTS_DAO.getAll();
    }

    public Subjects getById(final int subjectId) {
        Subjects subject;
        Optional <Subjects> subjectsOptional = SUBJECTS_DAO.getById(subjectId);
        if (!subjectsOptional.isPresent()) {
            System.err.println("This subject doesn't exist");
            throw new IllegalArgumentException("This object doesn't exist");
        }
        subject = subjectsOptional.get();
        return subject;
    }

    public void updateByObject(final Subjects subject) {
        SUBJECTS_DAO.updateByObject(subject);
    }

    public void removeById(final int subjectId) {
        if (!SUBJECTS_DAO.getById(subjectId).isPresent()) {
            System.err.println("This subject doesn't exist");
            throw new IllegalArgumentException("This object doesn't exist");
        }
        SUBJECTS_DAO.removeById(subjectId);
    }

    public Boolean ifSubjectObjectExist(final int id) {
        if (SUBJECTS_DAO.getById((id)).isPresent()) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
