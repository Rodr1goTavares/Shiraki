package io.github.rodr1gotavares.core.entities;

import java.time.LocalDateTime;

/**
 * @author Rodr1goTavares - <a href="https://github.com/Rodr1goTavares">GitHub</a>
 */
public record TaskResult(
        String taskName,
        String executedHost,
        LocalDateTime executionDate,
        String resultLog
) {}
