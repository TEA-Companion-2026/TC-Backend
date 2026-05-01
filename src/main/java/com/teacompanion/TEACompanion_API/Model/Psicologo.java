package com.teacompanion.TEACompanion_API.Model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("PSICOLOGO")
public class Psicologo extends Usuario {}
