package com.teacompanion.TEACompanion_API.Model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("INDIVIDUO")
public class Individuo extends Usuario {
}
