package com.teacompanion.TEACompanion_API.Model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("RESPONSAVEL")
public class Responsavel extends Usuario{}
