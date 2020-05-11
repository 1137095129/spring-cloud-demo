package org.wjf.springcloud.entity;

import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Info implements Serializable {

	private static final long serialVersionUID = -5813602462969032090L;
	private Integer id;

	private String info;

	private String name;
}
