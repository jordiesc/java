package com.jordi.horas.view;

import org.jordi.horas.domain.Hora;
import com.jordi.horas.view.util.JsfUtil;
import com.jordi.horas.view.util.JsfUtil.PersistAction;
import com.jordi.horas.repositorio.HoraFacade;
import com.jordi.horas.repositorio.ProjectoFacade;
import com.jordi.horas.repositorio.TareaFacade;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
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
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import org.jordi.horas.domain.Projecto;
import org.jordi.horas.domain.Tarea;

@Named("horaController")
@RequestScoped
public class HoraController implements Serializable {

    @EJB
    private com.jordi.horas.repositorio.HoraFacade ejbFacade;

    @Inject
    private ProjectoFacade projectoFacade;

    @Inject
    private TareaFacade tareaFacade;

    private List<Hora> items = null;
    private Hora selected;

    private List<Projecto> proyectos;
    private String proyecto;

    public String getProyecto() {
        return proyecto;
    }

    public void setProyecto(String proyecto) {
        this.proyecto = proyecto;
    }

    public String getTarea() {
        return tarea;
    }

    public void setTarea(String tarea) {
        this.tarea = tarea;
    }
    private String tarea;

    public List<Projecto> getProyectos() {
        return proyectos;
    }

    public void setProyectos(List<Projecto> proyectos) {
        this.proyectos = proyectos;
    }

    public List<Tarea> getTareas() {
        return tareas;
    }

    public void setTareas(List<Tarea> tareas) {
        this.tareas = tareas;
    }
    private List<Tarea> tareas;

    @PostConstruct
    public void init() {
       proyectos = projectoFacade.findAll();
       tareas = tareaFacade.findAll();
    }

   

    public HoraController() {

    }

    public Hora getSelected() {
        return selected;
    }

    public void setSelected(Hora selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private HoraFacade getFacade() {
        return ejbFacade;
    }

    public Hora prepareCreate() {
        System.out.println("en metodo create 1");
        selected = new Hora();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {

        System.out.println("en metodo create 2");
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/bundle").getString("HoraCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/bundle").getString("HoraUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/bundle").getString("HoraDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Hora> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        System.out.println("en metodo persist");
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

    public Hora getHora(java.lang.Long id) {
        return getFacade().find(id);
    }

    public List<Hora> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Hora> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    public void testeando() {
        System.out.println("testeando");
    }

    @FacesConverter(forClass = Hora.class)
    public static class HoraControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            System.out.println("en faces converter horas 1");
            if (value == null || value.length() == 0) {
                return null;
            }
            HoraController controller = (HoraController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "horaController");
            return controller.getHora(getKey(value));
        }

        java.lang.Long getKey(String value) {
            System.out.println("en faces converter horas 2");
            java.lang.Long key;
            key = Long.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Long value) {
            System.out.println("en faces converter horas 3");
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            System.out.println("en faces converter horas 4");
            if (object == null) {
                return null;
            }
            if (object instanceof Hora) {
                Hora o = (Hora) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Hora.class.getName()});
                return null;
            }
        }

    }

}
