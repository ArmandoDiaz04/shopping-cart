package com.api.shoppingCart.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.Valid;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.lang.Nullable;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@NoArgsConstructor
@ApiModel(description = "Items in shopping cart")
public class ItemDTO extends RepresentationModel<ItemDTO> implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("itemId")
    private Integer itemId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("imageUrl")
    private String imageUrl;

    @JsonProperty("quantity")
    private Integer quantity;

    @JsonProperty("unitPrice")
    private BigDecimal unitPrice = null;


    /**
     * Item Identifier
     *
     * @return id
     */
    @ApiModelProperty(value = "Item Identifier")
    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public ItemDTO itemId(Integer id) {
        this.itemId = id;
        return this;
    }


    /**
     * Item name
     *
     * @return name
     */
    @ApiModelProperty(value = "Item name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ItemDTO name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Item description
     *
     * @return description
     */
    @ApiModelProperty(value = "Item description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ItemDTO description(String description) {
        this.description = description;
        return this;
    }

    /**
     * Item image URL
     *
     * @return imageUrl
     */
    @ApiModelProperty(value = "Item image URL")
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public ItemDTO imageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }


    /**
     * The item quantity
     *
     * @return quantity
     */
    @ApiModelProperty(value = "The item quantity")
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public ItemDTO quantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }


    /**
     * The item's price per unit
     *
     * @return unitPrice
     */
    @ApiModelProperty(value = "The item's price per unit")
    @Valid
    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public ItemDTO unitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
        return this;
    }

    @Override
    public boolean equals(@Nullable Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ItemDTO item = (ItemDTO) o;
        return Objects.equals(this.itemId, item.itemId) &&
                Objects.equals(this.name, item.name) &&
                Objects.equals(this.description, item.description) &&
                Objects.equals(this.imageUrl, item.imageUrl) &&
                Objects.equals(this.quantity, item.quantity) &&
                Objects.equals(this.unitPrice, item.unitPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId, name, description, imageUrl, quantity, unitPrice);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Item {\n");
        sb.append("    id: ").append(toIndentedString(itemId)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    imageUrl: ").append(toIndentedString(imageUrl)).append("\n");
        sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
        sb.append("    unitPrice: ").append(toIndentedString(unitPrice)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}

