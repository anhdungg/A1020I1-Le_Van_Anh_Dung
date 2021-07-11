package vn.codegym.model;

import javax.persistence.*;

@Entity
@Table
public class ContractDetail {
    @Id
    @GeneratedValue
    private Integer id;

    private Integer quantity;

    @ManyToOne(targetEntity = AttachService.class)
    @JoinColumn(name = "attachService_id", referencedColumnName = "id")
    private AttachService attachService;

    @ManyToOne(targetEntity = Contract.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "contract_id", referencedColumnName = "id")
    private Contract contract;

    public ContractDetail() {
    }

    public ContractDetail(Integer quantity, AttachService attachService, Contract contract) {
        this.quantity = quantity;
        this.attachService = attachService;
        this.contract = contract;
    }

    public ContractDetail(Integer id, Integer quantity, AttachService attachService, Contract contract) {
        this.id = id;
        this.quantity = quantity;
        this.attachService = attachService;
        this.contract = contract;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public AttachService getAttachService() {
        return attachService;
    }

    public void setAttachService(AttachService attachService) {
        this.attachService = attachService;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }
}
