package com.github.andreldsr.gymup.data.exercise.entity

import com.github.andreldsr.gymup.domain.exercise.form.ExtraCreateForm
import com.github.andreldsr.gymup.domain.exercise.form.toModel
import com.github.andreldsr.gymup.domain.exercise.model.Extra
import com.github.andreldsr.gymup.domain.exercise.model.ExtraType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.util.UUID

@Entity
@Table(name = "extra")
data class ExtraEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val identifier: UUID = UUID.randomUUID(),
    val description: String,
    @Column(name = "order_number")
    val order: Int = 0,
    @Enumerated(EnumType.STRING)
    val type: ExtraType,
    @ManyToOne
    val exercise: ExerciseEntity
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as ExtraEntity
        return id == other.id
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }

    override fun toString(): String {
        return "id => $id || identifier => $identifier || description => $description"
    }
}

fun ExtraEntity.toModel() = Extra(
    id,
    identifier,
    description,
    order,
    type,
    exercise.toModel()
)

fun Extra.toEntity() = ExtraEntity(
    id,
    identifier,
    description,
    order,
    type,
    exercise.toEntity()
)
fun ExtraCreateForm.toEntity() = toModel().toEntity()
