package com.jordi.horas.view;

import org.jordi.horas.domain.Projecto;
import com.jordi.horas.view.util.JsfUtil;
import com.jordi.horas.view.util.JsfUtil.PersistAction;
import com.jordi.horas.repositorio.ProjectoFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("projectoController")
@SessionScoped
public class ProjectoController implements Serializable {

    @EJB
    private com.jordi.horas.repositorio.ProjectoFacade ejbFacade;
    private List<Projecto> items = null;
    private Projecto selected;

    public ProjectoController() {
    }

    public Projecto getSelected() {
        return selected;
    }

    public void setSelected(Projecto selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private ProjectoFacade getFacade() {
        return ejbFacade;
    }

    public Projecto prepareCreate() {
        selected = new Projecto();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/bundle").getString("ProjectoCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/bundle").getString("ProjectoUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/bundle").getString("ProjectoDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Projecto> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public Projecto getProjecto(java.lang.String id) {
        return getFacade().find(id);
    }

    public List<Projecto> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Projecto> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Projecto.class)
    public static class ProjectoControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            System.out.println("en faces converter proyecto -1");
            if (value == null || value.length() == 0) {
                return null;
            }
            ProjectoController controller = (ProjectoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "projectoController");
            return controller.getProjecto(getKey(value));
        }

        java.lang.String getKey(String value) {
             System.out.println("en faces converter proyecto 0");
            java.lang.String key;
            key = value;
            return key;
        }

        String getStringKey(java.lang.String value) {
             System.out.println("en faces converter proyecto 1");
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
             System.out.println("en faces converter proyecto1");
            if (object == null) {
                return null;
            }
            if (object instanceof Projecto) {
                Projecto o = (Projecto) object;
                return getStringKey(o.getCodigo());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Projecto.class.getName()});
                return null;
            }
        }

    }

}
