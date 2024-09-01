package com.ashu.practice.dto;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponseDto implements Serializable {

	@Serial
	private static final long serialVersionUID = 4802305410875463159L;

	private String message;

	private List<String> details;
}
