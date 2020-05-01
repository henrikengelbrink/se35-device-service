package se35.device.service.models.entities

import com.fasterxml.jackson.annotation.JsonIgnore
import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.Type
import java.time.Instant
import java.util.*
import javax.persistence.*

@MappedSuperclass
abstract class BaseEntity {

    @Id
    @GenericGenerator(name = "uuid-gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid-gen")
    @Type(type = "pg-uuid")
    open lateinit var id: UUID

    @Column(name = "updated_at")
    open var updatedAt: Instant = Instant.now()
    @Column(name = "created_at")
    open var createdAt: Instant = Instant.now()

    @JsonIgnore
    @Column(name = "deleted_at")
    open var deletedAt: Instant? = null

    @PrePersist
    open fun prePersist() {
        updatedAt = Instant.now()
        createdAt = updatedAt
    }

    @PreUpdate
    fun preUpdate() {
        updatedAt = Instant.now()
    }

}