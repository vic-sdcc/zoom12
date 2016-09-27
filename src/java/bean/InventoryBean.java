/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import model.CoopEducMaterial;
import model.CoopKey;
import model.CoopMaterialKey;
import model.CoopPmeSchedule;
import model.CoopPmeSubject;
import model.CoopPmeType;
import service.CoopEducMaterialFacadeREST;
import service.CoopKeyFacadeREST;
import service.CoopMaterialKeyFacadeREST;
import service.CoopPmeScheduleFacadeREST;
import service.CoopPmeSubjectFacadeREST;
import service.CoopPmeTypeFacadeREST;

/**
 *
 * @author mis
 */
@ManagedBean
@SessionScoped
public class InventoryBean implements Serializable{

    @PersistenceUnit
    EntityManagerFactory emf;

    @EJB
    private CoopKeyFacadeREST coopKeyFacadeREST;
    private CoopKey key = new CoopKey();
    @EJB
    private CoopEducMaterialFacadeREST coopEducMaterialFacadeREST;
    private CoopEducMaterial eduMat = new CoopEducMaterial();
    private List<CoopEducMaterial> edumatList;
    private DataModel<CoopEducMaterial> edumatModel;
    private CoopEducMaterial selectedMaterial = new CoopEducMaterial();
    @EJB
    private CoopMaterialKeyFacadeREST coopMaterialKeyFacadeREST;
    private CoopMaterialKey matKey = new CoopMaterialKey();
    @EJB
    private CoopPmeScheduleFacadeREST coopPmeScheduleFacadeREST;
    private CoopPmeSchedule pmeSched = new CoopPmeSchedule();
    private List<CoopPmeSchedule> pmeschedList;
    private DataModel<CoopPmeSchedule> pmeschedModel;
    private CoopPmeSchedule selectedPmeSchedule;
    @EJB
    private CoopPmeSubjectFacadeREST coopPmeSubjectFacadeREST;
    private CoopPmeSubject pmeSub = new CoopPmeSubject();
    private List<CoopPmeSubject> subjCode;
    @EJB
    private CoopPmeTypeFacadeREST coopPmeTypeFacadeREST;
    private CoopPmeType pmeTyp = new CoopPmeType();
    private List<CoopPmeType> pmeType;

    private ArrayList<CoopKey> keyTag = new ArrayList<>();
    private List<CoopKey> keyTagList;

    private Integer hrF;
    private Integer minF;
    private Integer hrT;
    private Integer minT;
    private Integer selectedTypeId;

    //keyTag***************************************************************
    public void addTxtBoxkey() {
        getKeyTag().add(new CoopKey());
    }

    public void removeTxtBoxkey() {
        if (getKeyTag().size() > 0) {
            getKeyTag().remove(getKeyTag().size() - 1);
        }
    }

    public ArrayList<CoopKey> getKeyTag() {
        return keyTag;
    }

    public void setKeyTag(ArrayList<CoopKey> keyTag) {
        this.keyTag = keyTag;
    }

    //**************************************************************************
    public void init() {
        edumatList = coopEducMaterialFacadeREST.findAll();
        subjCode = emf.createEntityManager().createQuery("SELECT c FROM CoopPmeSubject c").getResultList();
        pmeType = emf.createEntityManager().createQuery("SELECT c FROM CoopPmeType c WHERE c.fromType = 'L'").getResultList();
        setKeyTagList(coopKeyFacadeREST.findAll());
    }

    public void beanclear() {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("inventoryBean", null);
    }

    /**
     * Creates a new instance of InventoryBean
     */
    public InventoryBean() {
        eduMat = new CoopEducMaterial();
    }

    public CoopKeyFacadeREST getCoopKeyFacadeREST() {
        return coopKeyFacadeREST;
    }

    public void setCoopKeyFacadeREST(CoopKeyFacadeREST coopKeyFacadeREST) {
        this.coopKeyFacadeREST = coopKeyFacadeREST;
    }

    public CoopKey getKey() {
        return key;
    }

    public void setKey(CoopKey key) {
        this.key = key;
    }

    public CoopEducMaterialFacadeREST getCoopEducMaterialFacadeREST() {
        return coopEducMaterialFacadeREST;
    }

    public void setCoopEducMaterialFacadeREST(CoopEducMaterialFacadeREST coopEducMaterialFacadeREST) {
        this.coopEducMaterialFacadeREST = coopEducMaterialFacadeREST;
    }

    public CoopEducMaterial getEduMat() {
        return eduMat;
    }

    public void setEduMat(CoopEducMaterial eduMat) {
        this.eduMat = eduMat;
    }

    public List<CoopEducMaterial> getEdumatList() {
        return edumatList;
    }

    public void setEdumatList(List<CoopEducMaterial> edumatList) {
        this.edumatList = edumatList;
    }

    public DataModel<CoopEducMaterial> getEdumatModel() {
        return edumatModel;
    }

    public void setEdumatModel(DataModel<CoopEducMaterial> edumatModel) {
        this.edumatModel = edumatModel;
    }

    public CoopMaterialKeyFacadeREST getCoopMaterialKeyFacadeREST() {
        return coopMaterialKeyFacadeREST;
    }

    public void setCoopMaterialKeyFacadeREST(CoopMaterialKeyFacadeREST coopMaterialKeyFacadeREST) {
        this.coopMaterialKeyFacadeREST = coopMaterialKeyFacadeREST;
    }

    public CoopMaterialKey getMatKey() {
        return matKey;
    }

    public void setMatKey(CoopMaterialKey matKey) {
        this.matKey = matKey;
    }

    public CoopPmeSubjectFacadeREST getCoopPmeSubjectFacadeREST() {
        return coopPmeSubjectFacadeREST;
    }

    public void setCoopPmeSubjectFacadeREST(CoopPmeSubjectFacadeREST coopPmeSubjectFacadeREST) {
        this.coopPmeSubjectFacadeREST = coopPmeSubjectFacadeREST;
    }

    public CoopPmeSubject getPmeSub() {
        return pmeSub;
    }

    public void setPmeSub(CoopPmeSubject pmeSub) {
        this.pmeSub = pmeSub;
    }

    public CoopPmeTypeFacadeREST getCoopPmeTypeFacadeREST() {
        return coopPmeTypeFacadeREST;
    }

    public void setCoopPmeTypeFacadeREST(CoopPmeTypeFacadeREST coopPmeTypeFacadeREST) {
        this.coopPmeTypeFacadeREST = coopPmeTypeFacadeREST;
    }

    public CoopPmeType getPmeTyp() {
        return pmeTyp;
    }

    public void setPmeTyp(CoopPmeType pmeTyp) {
        this.pmeTyp = pmeTyp;
    }

    public CoopEducMaterial getSelectedMaterial() {
        if (selectedMaterial == null) {
            selectedMaterial = new CoopEducMaterial();
        }
        return selectedMaterial;
    }

    public void setSelectedMaterial(CoopEducMaterial selectedMaterial) {
        this.selectedMaterial = selectedMaterial;
    }

    public CoopPmeScheduleFacadeREST getCoopPmeScheduleFacadeREST() {
        return coopPmeScheduleFacadeREST;
    }

    public void setCoopPmeScheduleFacadeREST(CoopPmeScheduleFacadeREST coopPmeScheduleFacadeREST) {
        this.coopPmeScheduleFacadeREST = coopPmeScheduleFacadeREST;
    }

    public CoopPmeSchedule getPmeSched() {
        return pmeSched;
    }

    public void setPmeSched(CoopPmeSchedule pmeSched) {
        this.pmeSched = pmeSched;
    }

    public List<CoopPmeSchedule> getPmeschedList() {
        return pmeschedList;
    }

    public void setPmeschedList(List<CoopPmeSchedule> pmeschedList) {
        this.pmeschedList = pmeschedList;
    }

    public DataModel<CoopPmeSchedule> getPmeschedModel() {
        return pmeschedModel;
    }

    public void setPmeschedModel(DataModel<CoopPmeSchedule> pmeschedModel) {
        this.pmeschedModel = pmeschedModel;
    }

    public CoopPmeSchedule getSelectedPmeSchedule() {
        return selectedPmeSchedule;
    }

    public void setSelectedPmeSchedule(CoopPmeSchedule selectedPmeSchedule) {
        this.selectedPmeSchedule = selectedPmeSchedule;
    }

    public String save() {
        pmeTyp.setTypeId(selectedTypeId);
        eduMat.setTypeId(pmeTyp);
        coopEducMaterialFacadeREST.create(eduMat);

        for (int i = 0; i != keyTag.size(); i++) {
            matKey.setInvNo(eduMat);
            matKey.setKeyId(keyTag.get(i));
            coopMaterialKeyFacadeREST.create(matKey);
        }

        eduMat = new CoopEducMaterial();
        beanclear();
        keyTag = new ArrayList<>();
        return "addInventory";
    }

    public String delete() {
        tagsRemove();

        pmeTyp.setTypeId(selectedTypeId);
        eduMat.setTypeId(pmeTyp);
        coopEducMaterialFacadeREST.remove(selectedMaterial);

        selectedMaterial = new CoopEducMaterial();
        beanclear();
        return "viewInventory";
    }

    public String edit() {
        //keyTag = new ArrayList<>();
        //tagsGet();
        tagsRemove();

        for (int i = 0; i != keyTag.size(); i++) {
            matKey.setInvNo(selectedMaterial);
            matKey.setKeyId(keyTag.get(i));
            coopMaterialKeyFacadeREST.create(matKey);
        }

        pmeTyp.setTypeId(selectedTypeId);
        selectedMaterial.setTypeId(pmeTyp);
        coopEducMaterialFacadeREST.edit(selectedMaterial);
        selectedMaterial = new CoopEducMaterial();
        beanclear();
        return "viewInventory";
    }

    public Integer getHrF() {
        return hrF;
    }

    public void setHrF(Integer hrF) {
        this.hrF = hrF;
    }

    public Integer getMinF() {
        return minF;
    }

    public void setMinF(Integer minF) {
        this.minF = minF;
    }

    public Integer getHrT() {
        return hrT;
    }

    public void setHrT(Integer hrT) {
        this.hrT = hrT;
    }

    public Integer getMinT() {
        return minT;
    }

    public void setMinT(Integer minT) {
        this.minT = minT;
    }

    public List<CoopPmeSubject> getSubjCode() {
        return subjCode;
    }

    public void setSubjCode(List<CoopPmeSubject> subjCode) {
        this.subjCode = subjCode;
    }

    public List<CoopPmeType> getPmeType() {
        return pmeType;
    }

    public void setPmeType(List<CoopPmeType> pmeType) {
        this.pmeType = pmeType;
    }

    public Integer getSelectedTypeId() {
        return selectedTypeId;
    }

    public void setSelectedTypeId(Integer selectedTypeId) {
        this.selectedTypeId = selectedTypeId;
    }

    private List<CoopKey> keyList;
    private DataModel<CoopKey> keyModel;

    public void tagsGet() {
        Query CoopKeyQuery = emf.createEntityManager().createQuery("SELECT e FROM CoopMaterialKey c "
                + "JOIN c.invNo d JOIN c.keyId e "
                + "WHERE d.invNo = : " + selectedMaterial.getInvNo());
        keyList = CoopKeyQuery.getResultList();
        keyModel = new ListDataModel(keyList);

        if (keyModel.getRowCount() > 0) {
            for (int i = 0; i != keyModel.getRowCount(); i++) {
                CoopKey q = (CoopKey) emf.createEntityManager().createQuery("SELECT e FROM CoopMaterialKey c "
                        + "JOIN c.invNo d JOIN c.keyId e "
                        + "WHERE d.invNo = : " + selectedMaterial.getInvNo()).getResultList().get(i);
                keyTag.add(q);
            }
        }
    }

    public void tagsRemove() {
        Query CoopKeyQuery = emf.createEntityManager().createQuery("SELECT e FROM CoopMaterialKey c "
                + "JOIN c.invNo d JOIN c.keyId e "
                + "WHERE d.invNo = : " + selectedMaterial.getInvNo());
        keyList = CoopKeyQuery.getResultList();
        keyModel = new ListDataModel(keyList);

        if (keyModel.getRowCount() > 0) {
            for (int i = 0; i != keyModel.getRowCount(); i++) {
                CoopMaterialKey q = (CoopMaterialKey) emf.createEntityManager().createQuery("SELECT c FROM CoopMaterialKey c "
                        + "JOIN c.invNo d JOIN c.keyId e "
                        + "WHERE d.invNo = : " + selectedMaterial.getInvNo()).getResultList().get(0);
                coopMaterialKeyFacadeREST.remove(q);
            }
        }
    }

    public void CodeType() {
        keyTag = new ArrayList<>();
        tagsGet();
        setSelectedTypeId(selectedMaterial.getTypeId().getTypeId());

    }

    public String addBtn() {
        eduMat = new CoopEducMaterial();
        keyTag = new ArrayList<>();
        eduMat.setMatStat(true);
        return "/xhtml/addInventory.xhtml";
    }

    public String viewBtn() {
        beanclear();
        return "/xhtml/viewInventory.xhtml";
    }

    public String cancelBtn() {
        beanclear();
        return "/xhtml/mainInventory.xhtml";
    }

    public List<CoopKey> getKeyTagList() {
        return keyTagList;
    }

    public void setKeyTagList(List<CoopKey> keyTagList) {
        this.keyTagList = keyTagList;
    }
    
    public List<CoopKey> keyList(Integer invNo) {
        Query CoopKeyQuery = emf.createEntityManager().createQuery("SELECT e FROM CoopMaterialKey c JOIN c.invNo d JOIN c.keyId e WHERE d.invNo = : " + invNo);
        keyList = CoopKeyQuery.getResultList();
        
        return keyList;
    }

}
