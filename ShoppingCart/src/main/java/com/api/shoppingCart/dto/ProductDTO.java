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
@ApiModel(description = "Product information")
public class ProductDTO extends RepresentationModel<ProductDTO> implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("id")
    private String productId;

    @JsonProperty("title")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("image")
    private String imageUrl;

    @JsonProperty("price")
    private BigDecimal price = null;

    // @JsonProperty("count")
    // private Integer count;


    /**
     * Product identifier
     *
     * @return id
     */
    @ApiModelProperty(value = "Product identifier")
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public ProductDTO productId(String productId) {
        this.productId = productId;
        return this;
    }

    /**
     * Product Name
     *
     * @return name
     */
    @ApiModelProperty(value = "Product Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductDTO name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Prodcut's description
     *
     * @return description
     */
    @ApiModelProperty(value = "Prodcut's description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProductDTO description(String description) {
        this.description = description;
        return this;
    }

    /**
     * Product image's URL
     *
     * @return imageUrl
     */
    @ApiModelProperty(value = "Product image's URL")
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public ProductDTO imageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }


    /**
     * Product price
     *
     * @return price
     */
    @ApiModelProperty(value = "Product price")
    @Valid
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public ProductDTO price(BigDecimal price) {
        this.price = price;
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
        ProductDTO product = (ProductDTO) o;
        return Objects.equals(this.productId, product.productId) &&
                Objects.equals(this.name, product.name) &&
                Objects.equals(this.description, product.description) &&
                Objects.equals(this.imageUrl, product.imageUrl) &&
                Objects.equals(this.price, product.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, name, description, imageUrl, price);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Product {\n");

        sb.append("    productId: ").append(toIndentedString(productId)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    imageUrl: ").append(toIndentedString(imageUrl)).append("\n");
        sb.append("    price: ").append(toIndentedString(price)).append("\n");
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
