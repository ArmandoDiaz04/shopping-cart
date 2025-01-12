package com.api.shoppingCart.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.lang.Nullable;

import java.io.Serializable;
import java.util.Objects;

@NoArgsConstructor
@ApiModel(description = "Customer information required for payment processing")
public class CustomerInfoOnCardDTO extends RepresentationModel<CustomerInfoOnCardDTO> implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("lastName")
    private String lastName;


    /**
     * Customer first name
     *
     * @return firstName
     */
    @ApiModelProperty(value = "Customer first name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public CustomerInfoOnCardDTO firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }


    /**
     * Customer last name
     *
     * @return lastName
     */
    @ApiModelProperty(value = "Customer last name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public CustomerInfoOnCardDTO lastName(String lastName) {
        this.lastName = lastName;
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
        CustomerInfoOnCardDTO customerInfoOnCardDTO = (CustomerInfoOnCardDTO) o;
        return Objects.equals(this.firstName, customerInfoOnCardDTO.firstName) &&
                Objects.equals(this.lastName, customerInfoOnCardDTO.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CustomerInfoOnCard {\n");
        sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
        sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
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

