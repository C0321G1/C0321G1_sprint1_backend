package c0321g1_gaming.dto.computer;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.regex.Pattern;

public class ComputerDto implements Validator {
    private Long computerId;
    private String computerCode;
    private String location;
    @NotBlank
    private String configuration;
    private String startUsedDate;
    @NotBlank
    private String warrantyPeriod;
    private int flagDelete;
    private ComputerStatusDto computerStatus;
    private ComputerTypeDto computerType;
    private ComputerManufacturerDto computerManufacturer;


    public ComputerDto() {
    }

    public ComputerDto(Long computerId, String computerCode, String location, String configuration,
                       String startUsedDate, String warrantyPeriod, int flagDelete,
                       ComputerStatusDto computerStatus, ComputerTypeDto computerType,
                       ComputerManufacturerDto computerManufacturer) {
        this.computerId = computerId;
        this.computerCode = computerCode;
        this.location = location;
        this.configuration = configuration;
        this.startUsedDate = startUsedDate;
        this.warrantyPeriod = warrantyPeriod;
        this.flagDelete = flagDelete;
        this.computerStatus = computerStatus;
        this.computerType = computerType;
        this.computerManufacturer = computerManufacturer;
    }


    public Long getComputerId() {
        return computerId;
    }

    public String getComputerCode() {
        return computerCode;
    }

    public String getLocation() {
        return location;
    }

    public String getConfiguration() {
        return configuration;
    }

    public String getStartUsedDate() {
        return startUsedDate;
    }

    public String getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public int getFlagDelete() {
        return flagDelete;
    }

    public ComputerStatusDto getComputerStatus() {
        return computerStatus;
    }

    public ComputerTypeDto getComputerType() {
        return computerType;
    }

    public ComputerManufacturerDto getComputerManufacturer() {
        return computerManufacturer;
    }

    public void setComputerId(Long computerId) {
        this.computerId = computerId;
    }

    public void setComputerCode(String computerCode) {
        this.computerCode = computerCode;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setConfiguration(String configuration) {
        this.configuration = configuration;
    }

    public void setStartUsedDate(String startUsedDate) {
        this.startUsedDate = startUsedDate;
    }

    public void setWarrantyPeriod(String warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }

    public void setFlagDelete(int flagDelete) {
        this.flagDelete = flagDelete;
    }

    public void setComputerStatus(ComputerStatusDto computerStatus) {
        this.computerStatus = computerStatus;
    }

    public void setComputerType(ComputerTypeDto computerType) {
        this.computerType = computerType;
    }

    public void setComputerManufacturer(ComputerManufacturerDto computerManufacturer) {
        this.computerManufacturer = computerManufacturer;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    /*long-computer*/
    @Override
    public void validate(Object target, Errors errors) {
        ComputerDto computerDto = (ComputerDto) target;
        LocalDate dateNow = LocalDate.now();
        LocalDate startUsedDateLocal = LocalDate.parse(computerDto.startUsedDate);
        if (computerDto.getComputerCode() == null) {
            errors.rejectValue("computerCode", "computerCode.null",
                    "Computer ID is required");
        } else if (!Pattern.compile("^CP[0-9]{4}$").matcher(computerDto.computerCode).find()) {
            errors.rejectValue("computerCode", "computerCode.format",
                    "Enter the Computer Code in the format CPXXXX with an X from 0-9");
        }

        if (computerDto.computerManufacturer.getName() == null) {
            errors.rejectValue("computerManufacturer",
                    "computerManufacturer.null", "Computer Manufacturer is required");
        }

        if (computerDto.computerStatus.getName() == null) {
            errors.rejectValue("computerStatus", "computerStatus.null",
                    "Computer Status is required.");
        }

        if (computerDto.computerType.getName() == null) {
            errors.rejectValue("computerType", "computerType.null",
                    "Computer Type is required.");
        }

        if (computerDto.configuration == null) {
            errors.rejectValue("configuration", "configuration.null",
                    "Configuration is required.");
        } else if (computerDto.configuration.length() > 100) {
            errors.rejectValue("configuration", "configuration.maxLength",
                    "Configuration is too long.");
        }
        if (computerDto.location == null) {
            errors.rejectValue("location", "location.null",
                    "Location is required");
        } else if (!Pattern.compile("^(A[0-9]{4}|B[0-9]{4}|C[0-9]{4}|D[0-9]{4})$")
                .matcher(computerDto.location).find()) {
            errors.rejectValue("location", "location.format",
                    "Location is AXXXX or BXXXX or CXXXX or DXXXX with X from 0-9");
        }
        if (computerDto.startUsedDate == null) {
            errors.rejectValue("startUsedDate", "startUsedDate.null",
                    "Start Used Date is required");
        } else if (startUsedDateLocal.compareTo(dateNow) > 0) {
            errors.rejectValue("startUsedDate", "startUsedDate.compare",
                    "startUsedDate must <= date now");
        }
        if (computerDto.warrantyPeriod == null) {
            errors.rejectValue("warrantyPeriod", "warrantyPeriod.null",
                    "warrantyPeriod is required");
        } else if (computerDto.warrantyPeriod.length() > 20) {
            errors.rejectValue("warrantyPeriod", "warrantyPeriod.maxLength",
                    "warrantyPeriod is too long");
        }
        if (computerDto.flagDelete != 0 && computerDto.flagDelete != 1) {
            errors.rejectValue("flagDelete", "flagDelete.diff"
                    , "FlagDelete not valid 0 and 1");
        }

        if (!computerDto.computerType.getName().equals("Loại 1")
                && !computerDto.computerType.getName().equals("Loại 2")
                && !computerDto.computerType.getName().equals("Loại 3")) {
            errors.rejectValue("computerType", "computerType.name", "Name not valid");
        }

    }
}
