package com.github.andreldsr.gymup.data.musclegroup.entity

import com.github.andreldsr.gymup.domain.musclegroup.dto.toListDto
import com.github.andreldsr.gymup.domain.musclegroup.form.MuscleGroupCreateForm
import com.github.andreldsr.gymup.domain.musclegroup.form.toModel
import com.github.andreldsr.gymup.domain.musclegroup.model.MuscleGroup
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.annotations.UpdateTimestamp
import org.springframework.data.annotation.CreatedDate
import java.time.LocalDateTime
import java.util.UUID

@Entity
@Table(name = "muscle_group")
data class MuscleGroupEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val identifier: UUID,
    val name: String,
    @Column(name = "created_at") @CreatedDate
    val createdAt: LocalDateTime = LocalDateTime.now(),
    @Column(name = "updated_at") @UpdateTimestamp
    val updatedAt: LocalDateTime = LocalDateTime.now()
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as MuscleGroupEntity
        return id == other.id
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }

    override fun toString(): String {
        return "id => $id || identifier => $identifier || name => $name"
    }
}

fun MuscleGroupEntity.toModel() = MuscleGroup(
    id = id,
    identifier = identifier,
    name = name
)

fun MuscleGroup.toEntity() = MuscleGroupEntity(
    id = id,
    identifier = identifier,
    name = name
)

fun MuscleGroupCreateForm.toEntity() = toModel().toEntity()
fun MuscleGroupEntity.toListDto() = toModel().toListDto()
